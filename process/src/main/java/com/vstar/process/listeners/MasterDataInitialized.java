package com.vstar.process.listeners;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import com.vstar.process.jaxb.MasterData;
import com.vstar.process.jaxb.converters.LocationDataConverter;
import com.vstar.process.masterData.MasterDataProcess;

public class MasterDataInitialized implements
		ApplicationListener<ContextRefreshedEvent> {

	// System property for XML binding namespace mapper
	private static final String XML_BIND_NAMESPACE_MAPPER_PROP = "com.sun.xml.bind.namespacePrefixMapper";
	private MasterDataProcess masterDataProcess;

	/**
	 * Logger instance for the class
	 */

	protected Log logger = LogFactory.getLog(this.getClass());

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Map<String, Map<String, List<String>>> countries = masterDataProcess
				.getLocationMasterData();
		MasterData masterData = new MasterData();
		LocationDataConverter.convertLocationMasterData(masterData, countries);

		try {
			masrshallMasterDatatToFile(masterData);
		} catch (JAXBException e) {
			 logger.error("Could not create file::"+e.getMessage());
		} catch (URISyntaxException e) {
			 logger.error("Could not create file::"+e.getMessage());
		}

	}

	private void masrshallMasterDatatToFile(MasterData masterData)
			throws JAXBException, URISyntaxException {

		URI uri = new URI("file:/c:/temp/masterData.xml");
		Marshaller marshaller = JAXBContext.newInstance(MasterData.class)
				.createMarshaller();
		// namespace prefix mapper
		NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
			public String getPreferredPrefix(String namespaceUri,
					String suggestion, boolean requirePrefix) {
				return "";
			}
		};

		// setting XML binding property
		marshaller.setProperty(XML_BIND_NAMESPACE_MAPPER_PROP, mapper);

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// marshalling the object to string writer
		marshaller.marshal(masterData, new File(uri));
	}

	public MasterDataProcess getMasterDataProcess() {
		return masterDataProcess;
	}

	public void setMasterDataProcess(MasterDataProcess masterDataProcess) {
		this.masterDataProcess = masterDataProcess;
	}

}
