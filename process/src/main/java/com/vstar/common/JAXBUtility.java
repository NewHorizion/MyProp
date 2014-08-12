package com.vstar.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUtility {

	public static Object getUnmarshalledOnbject(String path, String packageName) {
		URI uri;
		try {
			uri = new URI(path);
			File xmlFile = new File(uri);
			// creating JAXB context for the group setup
			JAXBContext context;
			Unmarshaller unmarshaller;

			context = JAXBContext.newInstance(packageName);
			unmarshaller = context.createUnmarshaller();
			InputStream is;
			is = new FileInputStream(xmlFile);
			return unmarshaller.unmarshal(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
}
