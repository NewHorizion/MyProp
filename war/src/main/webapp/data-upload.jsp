<%@ page contentType="text/html; charset=UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>  
<html>  
    <head>  
        <title>Upload User Data</title>  
    </head>  
    <body>  
        <h2>  
            Struts2 File Upload  
        </h2>  
        <s:actionerror />  
        <s:form action="/webservice/UploadData.action" method="post" enctype="multipart/form-data">  
            <s:file name="dataFile" label="Data File" />  
            <s:submit value="Upload" align="center" />  
        </s:form>  
    </body>  
</html>  