// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package boxconnector.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import static boxconnector.proxies.microflows.Microflows.downloadFileImpl;

/**
 * Retrieves the actual data of the file. An optional version parameter can be set to download a previous version of the file.
 * 
 * Required
 * BoxFile: the file to delete.
 * _id attribute is required.
 * 
 * 
 * Optional
 * Version: the version of the file
 */
public class DownloadFile extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __BoxFileParameter1;
	private boxconnector.proxies.BoxFile BoxFileParameter1;
	private java.lang.String Version;

	public DownloadFile(IContext context, IMendixObject BoxFileParameter1, java.lang.String Version)
	{
		super(context);
		this.__BoxFileParameter1 = BoxFileParameter1;
		this.Version = Version;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.BoxFileParameter1 = __BoxFileParameter1 == null ? null : boxconnector.proxies.BoxFile.initialize(getContext(), __BoxFileParameter1);

		// BEGIN USER CODE
		boxconnector.proxies.BoxDocument document = downloadFileImpl(getContext(), BoxFileParameter1, Version);
		if(document != null)
			return document.getMendixObject();
		else
			return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "DownloadFile";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}