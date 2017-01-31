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
import static boxconnector.proxies.microflows.Microflows.updateFolderImpl;

/**
 * Used to update information about the folder. To move a folder, update the ID of its parent. To enable an email address that can be used to upload files to this folder, update the folder_upload_email.
 * 
 * Required
 * BoxFolder: The folder to update.
 * The _id attribute is required.
 * 
 * Optional (but at least one of them must be specified)
 * UpdateName : The new name
 * UpdateDescription: The new description
 * UpdateParentFolder: The folder where to move the file
 * UpdateSharedLink: The SharedLink to update with its new attributes
 * UpdateFolderUploadEmail: The FolderUploadEmail to update with its new attributes
 * UpdateSyncState: Whether Box Sync clients will sync this folder. Values of synced or not_synced can be sent, while partially_synced may also be returned.
 * UpdateTags: All tags attached to this folder.
 */
public class UpdateFolder extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __BoxFolderParameter1;
	private boxconnector.proxies.BoxFolder BoxFolderParameter1;
	private java.lang.String UpdateName;
	private java.lang.String UpdateDescription;
	private IMendixObject __UpdateParentFolder;
	private boxconnector.proxies.BoxFolder UpdateParentFolder;
	private IMendixObject __UpdateSharedLink;
	private boxconnector.proxies.SharedLink UpdateSharedLink;
	private IMendixObject __UpdateFolderUploadEmail;
	private boxconnector.proxies.FolderUploadEmail UpdateFolderUploadEmail;
	private boxconnector.proxies.BoxSyncState UpdateSyncState;
	private java.util.List<IMendixObject> __UpdateTags;
	private java.util.List<boxconnector.proxies.TagValue> UpdateTags;

	public UpdateFolder(IContext context, IMendixObject BoxFolderParameter1, java.lang.String UpdateName, java.lang.String UpdateDescription, IMendixObject UpdateParentFolder, IMendixObject UpdateSharedLink, IMendixObject UpdateFolderUploadEmail, java.lang.String UpdateSyncState, java.util.List<IMendixObject> UpdateTags)
	{
		super(context);
		this.__BoxFolderParameter1 = BoxFolderParameter1;
		this.UpdateName = UpdateName;
		this.UpdateDescription = UpdateDescription;
		this.__UpdateParentFolder = UpdateParentFolder;
		this.__UpdateSharedLink = UpdateSharedLink;
		this.__UpdateFolderUploadEmail = UpdateFolderUploadEmail;
		this.UpdateSyncState = UpdateSyncState == null ? null : boxconnector.proxies.BoxSyncState.valueOf(UpdateSyncState);
		this.__UpdateTags = UpdateTags;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.BoxFolderParameter1 = __BoxFolderParameter1 == null ? null : boxconnector.proxies.BoxFolder.initialize(getContext(), __BoxFolderParameter1);

		this.UpdateParentFolder = __UpdateParentFolder == null ? null : boxconnector.proxies.BoxFolder.initialize(getContext(), __UpdateParentFolder);

		this.UpdateSharedLink = __UpdateSharedLink == null ? null : boxconnector.proxies.SharedLink.initialize(getContext(), __UpdateSharedLink);

		this.UpdateFolderUploadEmail = __UpdateFolderUploadEmail == null ? null : boxconnector.proxies.FolderUploadEmail.initialize(getContext(), __UpdateFolderUploadEmail);

		this.UpdateTags = new java.util.ArrayList<boxconnector.proxies.TagValue>();
		if (__UpdateTags != null)
			for (IMendixObject __UpdateTagsElement : __UpdateTags)
				this.UpdateTags.add(boxconnector.proxies.TagValue.initialize(getContext(), __UpdateTagsElement));

		// BEGIN USER CODE
		boxconnector.proxies.BoxFolder boxFolder = updateFolderImpl(getContext(), BoxFolderParameter1, UpdateName, UpdateDescription, UpdateParentFolder, UpdateSharedLink, UpdateFolderUploadEmail, UpdateSyncState, UpdateTags);

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
		return "UpdateFolder";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}