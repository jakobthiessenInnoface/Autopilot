package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.IdentifierType;
import io.adminshell.aas.v3.model.Key;
import io.adminshell.aas.v3.model.KeyElements;
import io.adminshell.aas.v3.model.KeyType;
import io.adminshell.aas.v3.model.LangString;
import io.adminshell.aas.v3.model.Reference;
import io.adminshell.aas.v3.model.impl.DefaultIdentifier;
import io.adminshell.aas.v3.model.impl.DefaultReference;

public class JtAAS {

	private String                     id;
	private String                     idShort;
	private JtNameplate                jtNameplate;
	private JtIdentification           jtIdentification;
	private JtAsset                    jtAsset;
	private MyAssetAdministrationShell aas          = new MyAssetAdministrationShell();
	private DefaultIdentifier          identifier   = new DefaultIdentifier();
	private List<Reference>            smReferences = new ArrayList<Reference>();
	private DefaultReference           assetRef     = new DefaultReference();
	
	public JtAAS(String id, String idShort, JtAsset jtAsset, JtNameplate jtNameplate, JtIdentification jtIdentification) {
		this.id = id;
		this.idShort = idShort;
		this.jtAsset = jtAsset;
		this.jtNameplate = jtNameplate;
		this.jtIdentification = jtIdentification;
		this.build();
	}
	
	private void build() {
		this.buildIdentifier();
		this.buildSmReferences();
		this.buildAssetRef();
		this.aas.setIdShort(this.idShort);
		
		// Displayname
		List<LangString> displayNames = new ArrayList<LangString>();
		LangString displayNameDE = new LangString();
		displayNameDE.setLanguage("DE");
		displayNameDE.setValue("Display Name");
		displayNames.add(displayNameDE);
		this.aas.setDisplayNames(displayNames);
		
		
		//Description
		List<LangString> descriptions = new ArrayList<LangString>();
		LangString descriptionDE = new LangString();
		descriptionDE.setLanguage("DE");
		descriptionDE.setValue("description");
		descriptions.add(descriptionDE);
		this.aas.setDescriptions(descriptions);
		
		
		this.aas.setCategory("CONSTANT");
		this.aas.setIdentification(this.identifier);
		this.aas.setSubmodels(this.smReferences);
		this.aas.setAsset(this.assetRef);
	}
	
	private void buildIdentifier() {
		this.identifier.setIdType(IdentifierType.IRI);
		this.identifier.setIdentifier(this.id);
	}
	
	private void buildSmReferences() {
		DefaultReference nameplateReference      = new DefaultReference();
		DefaultReference identificationReference = new DefaultReference();
		List<Key> keysForNameplate = new ArrayList<Key>();
		List<Key> keysForIdentification = new ArrayList<Key>();
		keysForNameplate.add(this.jtNameplate.getKey());
		keysForIdentification.add(this.jtIdentification.getKey());
		nameplateReference.setKeys(keysForNameplate);
		identificationReference.setKeys(keysForIdentification);
		this.smReferences.add(nameplateReference);
		this.smReferences.add(identificationReference);
	}
	
	private void buildAssetRef() {
		List<Key> keys = new ArrayList<Key>();
		MyKey key = new MyKey();
		key.setValue(this.jtAsset.getId());
		key.setType(KeyElements.ASSET);
		key.setIdType(KeyType.IRI);
		key.setLocal(Boolean.TRUE);
		keys.add(key);
		this.assetRef.setKeys(keys);
	}
	
	public MyAssetAdministrationShell get() {
		return this.aas;
	}
}
