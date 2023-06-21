package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.ConceptDescription;
import io.adminshell.aas.v3.model.IdentifierType;
import io.adminshell.aas.v3.model.Key;
import io.adminshell.aas.v3.model.KeyElements;
import io.adminshell.aas.v3.model.KeyType;
import io.adminshell.aas.v3.model.ModelingKind;
import io.adminshell.aas.v3.model.SubmodelElement;
import io.adminshell.aas.v3.model.impl.DefaultIdentifier;
import io.adminshell.aas.v3.model.impl.DefaultKey;
import io.adminshell.aas.v3.model.impl.DefaultReference;
import io.adminshell.aas.v3.model.impl.DefaultSubmodel;

public abstract class JtSubmodel {

	protected       String                           id;
	protected String idShort;
	protected String                           globalReferenceIdentifier;
	protected final KeyElements                      TYPE                             = KeyElements.SUBMODEL;
	protected       DefaultSubmodel                  submodel = new DefaultSubmodel();;
	protected       DefaultKey                       keyToStdSubmodel = new DefaultKey();
	protected       DefaultReference                 semanticId = new DefaultReference();
	protected       DefaultIdentifier                identifier = new DefaultIdentifier();
	protected       List<SubmodelElement>            elements = new ArrayList<SubmodelElement>();
	//private       JtNameOfSupplier                 jtNameOfSupplier                 = new JtNameOfSupplier("Festo AG & Co. KG");
	//private       JtManufacturerName               jtManufacturerName               = new JtManufacturerName("Festo AG & Co. KG");
	//private       JtManufacturerProductDesignation jtManufacturerProductDesignation = new JtManufacturerProductDesignation("OVEL Vacuum generator");
	
	public JtSubmodel( String id ) {
		this.id = id;
	}
	
	protected void buildKeyToStdSubmodel() {
		this.keyToStdSubmodel.setType(KeyElements.GLOBAL_REFERENCE);
		this.keyToStdSubmodel.setIdType(KeyType.IRI);
		this.keyToStdSubmodel.setValue(this.globalReferenceIdentifier);
	}
	
	protected void buildIdentifier() {
		this.identifier.setIdType(IdentifierType.IRI);
		this.identifier.setIdentifier(this.id);
	}
	
	protected void buildSemanticID() {
		this.buildKeyToStdSubmodel();
		List<Key> keys = new ArrayList<Key>();
		keys.add(this.keyToStdSubmodel);
		this.semanticId.setKeys(keys);
	}
	
	protected void build() {
		this.buildSemanticID();
		this.buildIdentifier();;
		this.submodel.setIdShort(this.idShort);
		this.submodel.setIdentification(this.identifier);
		this.submodel.setSemanticId(this.semanticId);
		this.submodel.setKind(ModelingKind.INSTANCE);
		this.submodel.setSubmodelElements(this.elements);
	}
	
	public DefaultSubmodel get() {
		return this.submodel;
	}
	
	public MyKey getKey() {
		MyKey key = new MyKey();
		//nameplateKey.setIdType(KeyType.valueOf(this.nameplateID.getIdType().toString()));
		key.setIdType(KeyType.IRI);
		key.setValue(this.identifier.getIdentifier());
		key.setType(this.TYPE);
		key.setLocal(Boolean.TRUE);
		return key;
	}
	
	public List<ConceptDescription> getConceptDescriptions() {
		return null;
	}
	
	public void buildElements() {
	}
	
}
