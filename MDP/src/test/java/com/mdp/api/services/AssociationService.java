package com.mdp.api.services;

import com.mdp.api.modals.CreateAssociation;
import com.selenium.utils.SeleniumUtils;

public class AssociationService extends SeleniumUtils {
	
	public CreateAssociation payload_CreateAsc(int iD,String ascName,String ascDesc,Boolean ascStatus)
	{
		return CreateAssociation.builder()
									.Id(iD)
									.Name(ascName)
									.Description(ascDesc)
									.IsActive(ascStatus)
									.build();
	}//"RandomAssc21120191130"
	

	
}
