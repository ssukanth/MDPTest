package com.mdp.api.modals;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateAssociation {
	  int Id;
	  @NonNull String Name;
	  String Description;
	  boolean  IsActive;
}

