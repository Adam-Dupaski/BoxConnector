// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package boxconnector.actions;

import static boxconnector.proxies.microflows.Microflows.permanentlyDeleteFileImpl;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Permanently deletes a file that is in the trash. The item will no longer exist in Box. This action cannot be undone.
 * 
 * Required
 * BoxFile: the file to delete
 * The _id attribute is required.
 */
public class PermanentlyDeleteFile extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __BoxFileParam;
	private boxconnector.proxies.BoxFile BoxFileParam;

	public PermanentlyDeleteFile(IContext context, IMendixObject BoxFileParam)
	{
		super(context);
		this.__BoxFileParam = BoxFileParam;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.BoxFileParam = __BoxFileParam == null ? null : boxconnector.proxies.BoxFile.initialize(getContext(), __BoxFileParam);

		// BEGIN USER CODE
		Boolean result = permanentlyDeleteFileImpl(getContext(), BoxFileParam);
		return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "PermanentlyDeleteFile";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
