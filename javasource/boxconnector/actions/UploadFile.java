// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package boxconnector.actions;

import static boxconnector.proxies.microflows.Microflows.uploadFileImpl;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import boxconnector.proxies.BoxFile;

/**
 * Use the Uploads to allow users to add a new file. 
 * 
 * Required
 * FileToUpload: The file to upload to Box.
 * The attribute name is required.
 * 
 * BoxFolder: The destination box folder.
 * The attribute _id is required.
 * 
 */
public class UploadFile extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __FileToUpload;
	private system.proxies.FileDocument FileToUpload;
	private IMendixObject __BoxFolderParameter1;
	private boxconnector.proxies.BoxFolder BoxFolderParameter1;

	public UploadFile(IContext context, IMendixObject FileToUpload, IMendixObject BoxFolderParameter1)
	{
		super(context);
		this.__FileToUpload = FileToUpload;
		this.__BoxFolderParameter1 = BoxFolderParameter1;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.FileToUpload = __FileToUpload == null ? null : system.proxies.FileDocument.initialize(getContext(), __FileToUpload);

		this.BoxFolderParameter1 = __BoxFolderParameter1 == null ? null : boxconnector.proxies.BoxFolder.initialize(getContext(), __BoxFolderParameter1);

		// BEGIN USER CODE
		BoxFile boxFile = uploadFileImpl(getContext(), FileToUpload, BoxFolderParameter1);
		if(boxFile != null) {
			return boxFile.getMendixObject();
		} else {
			return null;
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "UploadFile";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}