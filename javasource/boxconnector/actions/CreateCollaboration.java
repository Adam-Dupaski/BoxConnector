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
import static boxconnector.proxies.microflows.Microflows.createCollaborationImpl;

/**
 * Used to add a collaboration for a single user or a single group to a file or folder. Either an email address, a user id, or a group id can be used to create the collaboration.
 * 
 * Required
 * BoxItem: The item to which the collaboration will be added. It can be a BoxFile or a BoxFolder.
 * _id and _type attributes are required.
 * 
 * BoxUser: The box user added as a collaborator. 
 * A BoxUser can describe a group or a single user. The login (email address) is used only for single user.
 * 
 * CollaborationRole: The role applied to the collaborator.
 * 
 * Optional:
 * Notify: Determines if the user, (or all the users in the group) should receive email notification of the collaboration.
 * 
 * CanViewPath: View path collaborations allow the invitee to see the entire ancestral path to the associated folder. 
 */
public class CreateCollaboration extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __BoxItemParam;
	private boxconnector.proxies.BoxItem BoxItemParam;
	private IMendixObject __BoxUserParam;
	private boxconnector.proxies.BoxUser BoxUserParam;
	private boxconnector.proxies.CollaborationRole CollaborationRoleParam;
	private java.lang.Boolean Notify;
	private java.lang.Boolean CanViewPath;

	public CreateCollaboration(IContext context, IMendixObject BoxItemParam, IMendixObject BoxUserParam, java.lang.String CollaborationRoleParam, java.lang.Boolean Notify, java.lang.Boolean CanViewPath)
	{
		super(context);
		this.__BoxItemParam = BoxItemParam;
		this.__BoxUserParam = BoxUserParam;
		this.CollaborationRoleParam = CollaborationRoleParam == null ? null : boxconnector.proxies.CollaborationRole.valueOf(CollaborationRoleParam);
		this.Notify = Notify;
		this.CanViewPath = CanViewPath;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.BoxItemParam = __BoxItemParam == null ? null : boxconnector.proxies.BoxItem.initialize(getContext(), __BoxItemParam);

		this.BoxUserParam = __BoxUserParam == null ? null : boxconnector.proxies.BoxUser.initialize(getContext(), __BoxUserParam);

		// BEGIN USER CODE
		boxconnector.proxies.BoxCollaboration boxC = createCollaborationImpl(getContext(), BoxItemParam,
				BoxUserParam, CollaborationRoleParam, Notify, CanViewPath);
		if (boxC != null)
			return boxC.getMendixObject();
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
		return "CreateCollaboration";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
