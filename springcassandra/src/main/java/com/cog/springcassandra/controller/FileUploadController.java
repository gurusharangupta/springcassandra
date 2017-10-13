package com.cog.springcassandra.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import com.google.common.io.Files;

import io.swagger.annotations.Api;

@Component
@Path("/verifyuser")
@Api(value = "File Upload resource", produces = "application/json")
public class FileUploadController {

	
	@Path("/file")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(@DefaultValue("") @FormDataParam("email") String username, 
			@DefaultValue("") @FormDataParam("password") String password, 
				@FormDataParam("accountForm") InputStream file,
				@FormDataParam("accountForm") FormDataContentDisposition fileDisposition) {

		String fileName = fileDisposition.getFileName();
		
		saveFile(file, fileName);
		
		String fileDetails = "File saved at C:\\\\Users\\\\hiresmart\\\\PROJECT_DATA\\\\UPLOAD_DOCS\\\\" + fileName + " with tags";

		System.out.println(fileDetails);

		return  Response.status(200).entity(fileDetails).build();
	}
	
	private void saveFile(InputStream inputStreamFile, String name) {
		/* Change directory path */
		java.nio.file.Path path = FileSystems.getDefault().getPath("C:\\Users\\hiresmart\\PROJECT_DATA\\UPLOAD_DOCS\\" + name); 
		System.out.println(path);
		File newFile = new File(path.toString());
		
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(newFile);
			IOUtils.copy(inputStreamFile, outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Save InputStream as file */
	}
}