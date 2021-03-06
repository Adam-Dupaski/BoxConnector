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
import static boxconnector.proxies.microflows.Microflows.getFolderInfoImpl;

/**
 * Retrieves the full information about a folder, including information about when it was last updated as well as the files and folders contained in it. The root folder of a Box account is always represented by the id "0".
 * 
 * Required
 * BoxFolder
 * The _id attribute is required.
 */
public class GetFolderInfo extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __BoxFolderParam;
	private boxconnector.proxies.BoxFolder BoxFolderParam;

	public GetFolderInfo(IContext context, IMendixObject BoxFolderParam)
	{
		super(context);
		this.__BoxFolderParam = BoxFolderParam;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.BoxFolderParam = __BoxFolderParam == null ? null : boxconnector.proxies.BoxFolder.initialize(getContext(), __BoxFolderParam);

		// BEGIN USER CODE
		boxconnector.proxies.BoxFolder boxFolder = getFolderInfoImpl(getContext(), BoxFolderParam);
		if (boxFolder != null)
			return boxFolder.getMendixObject();
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
		return "GetFolderInfo";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
