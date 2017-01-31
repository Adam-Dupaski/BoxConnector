// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package boxconnector.actions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.io.IOUtils;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import boxconnector.proxies.constants.Constants;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class UploadFileVersionCall extends CustomJavaAction<java.lang.String>
{
	private IMendixObject __AccessTokenParameter1;
	private boxconnector.proxies.AccessToken AccessTokenParameter1;
	private IMendixObject __BoxFileParameter1;
	private boxconnector.proxies.BoxFile BoxFileParameter1;
	private IMendixObject __FileToUpload;
	private system.proxies.FileDocument FileToUpload;

	public UploadFileVersionCall(IContext context, IMendixObject AccessTokenParameter1, IMendixObject BoxFileParameter1, IMendixObject FileToUpload)
	{
		super(context);
		this.__AccessTokenParameter1 = AccessTokenParameter1;
		this.__BoxFileParameter1 = BoxFileParameter1;
		this.__FileToUpload = FileToUpload;
	}

	@Override
	public java.lang.String executeAction() throws Exception
	{
		this.AccessTokenParameter1 = __AccessTokenParameter1 == null ? null : boxconnector.proxies.AccessToken.initialize(getContext(), __AccessTokenParameter1);

		this.BoxFileParameter1 = __BoxFileParameter1 == null ? null : boxconnector.proxies.BoxFile.initialize(getContext(), __BoxFileParameter1);

		this.FileToUpload = __FileToUpload == null ? null : system.proxies.FileDocument.initialize(getContext(), __FileToUpload);

		// BEGIN USER CODE
		
		String URL = Constants.getBoxAPI_URL_Upload() + "/" + this.BoxFileParameter1.get_id() + "/content" ;

		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(URL);
		postMethod.setRequestHeader("Authorization", "Bearer " + this.AccessTokenParameter1);

		List<Part> parts = new ArrayList<Part>();
		
		String fileName = "";
		if(this.BoxFileParameter1.getname() != null
				&& !this.BoxFileParameter1.getname().isEmpty()) {
			parts.add(new StringPart("name", this.BoxFileParameter1.getname()));
			fileName = this.BoxFileParameter1.getname();
		}
		
		ByteArrayPartSource source = new ByteArrayPartSource(fileName,
				IOUtils.toByteArray(Core.getFileDocumentContent(getContext(), this.FileToUpload.getMendixObject())));
		parts.add(new FilePart("file", source));

		postMethod.setRequestEntity(new MultipartRequestEntity(parts.toArray(new Part[0]), postMethod.getParams()));
		httpClient.executeMethod(postMethod);
		
		int status = postMethod.getStatusCode();
		
		if(status == HttpURLConnection.HTTP_OK ) {
			int BUFFER_SIZE = 8192;
			InputStreamReader input = new InputStreamReader(postMethod.getResponseBodyAsStream(),	StandardCharsets.UTF_8);
			
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[BUFFER_SIZE];
	
			try {
				int read = input.read(buffer, 0, BUFFER_SIZE);
				while (read != -1) {
					builder.append(buffer, 0, read);
					read = input.read(buffer, 0, BUFFER_SIZE);
				}
			} catch (IOException e) {
				System.out.println(e.getStackTrace());
				return null;
			} finally {
				input.close();
				postMethod.releaseConnection();
			}
			
			String jsonText = builder.toString();
			
			return jsonText;
		} else {
			postMethod.releaseConnection();
			throw new com.mendix.systemwideinterfaces.MendixRuntimeException("" + status);
		}
		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "UploadFileVersionCall";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}