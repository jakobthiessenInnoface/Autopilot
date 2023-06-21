package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.DataTypeIEC61360;
import io.adminshell.aas.v3.model.EmbeddedDataSpecification;
import io.adminshell.aas.v3.model.IdentifierType;
import io.adminshell.aas.v3.model.LangString;
import io.adminshell.aas.v3.model.impl.DefaultConceptDescription;
import io.adminshell.aas.v3.model.impl.DefaultDataSpecificationIEC61360;
import io.adminshell.aas.v3.model.impl.DefaultEmbeddedDataSpecification;
import io.adminshell.aas.v3.model.impl.DefaultIdentifier;

public class CDforManufacturerProductDesignation {

	private final String                           ID                             = "0173-1#02-AAW338#001";
	private       DefaultConceptDescription        conceptDescription             = new DefaultConceptDescription();
	private       DefaultIdentifier                identifier                     = new DefaultIdentifier();
	private       List<EmbeddedDataSpecification>  embeddedDataSpecifications     = new ArrayList<EmbeddedDataSpecification>();
	private       List<LangString>                 definitions                    = new ArrayList<LangString>();
	private       List<LangString>                 prefNames                      = new ArrayList<LangString>();
	private       List<LangString>                 shortNames                     = new ArrayList<LangString>();
	private       DefaultDataSpecificationIEC61360 dsIEC61360                     = new DefaultDataSpecificationIEC61360();
	
	public CDforManufacturerProductDesignation() {
		this.build();
	}
	
	private void build() {
		this.buildConceptDescriptionID();
		this.buildEmbeddedDataSpecifications();
		this.conceptDescription.setIdShort("ManufacturerProductDesignation");
		this.conceptDescription.setCategory("Instance");
		this.conceptDescription.setIdentification(this.identifier);
		this.conceptDescription.setEmbeddedDataSpecifications(this.embeddedDataSpecifications);
	}
	
	private void buildConceptDescriptionID() {
		this.identifier.setIdType(IdentifierType.IRDI);
		this.identifier.setIdentifier(this.ID);
	}
	
	private void buildEmbeddedDataSpecifications() {
		this.buildDataSpecIEC61360();
		DefaultEmbeddedDataSpecification eds = new DefaultEmbeddedDataSpecification();
		eds.setDataSpecificationContent(this.dsIEC61360);
		this.embeddedDataSpecifications.add(eds);
	}
	
	private void buildDefinitions() {
		LangString definitionEN = new LangString();
		LangString definitionDE = new LangString();
		definitionEN.setLanguage("EN");
		definitionEN.setValue("Short description of the product (short text)");
		definitionDE.setLanguage("DE");
		definitionDE.setValue("Kurze Beschreibung des Produktes (Kurztext)");
		this.definitions.add(definitionEN);
		this.definitions.add(definitionDE);
	}
	
	private void buildPrefNames() {
		LangString nameEN = new LangString();
		LangString nameDE = new LangString();
		nameEN.setLanguage("EN");
		nameEN.setValue("Manufacturer product designation");
		nameDE.setLanguage("DE");
		nameDE.setValue("Herstellerproduktbezeichnung");
		this.prefNames.add(nameEN);
		this.prefNames.add(nameDE);
	}
	
	private void buildShortNames() {
		LangString shortNameEN = new LangString();
		shortNameEN.setLanguage("EN");
		shortNameEN.setValue("ManufacturerTypName");
		this.shortNames.add(shortNameEN);
	}
	
	private void buildDataSpecIEC61360() {
		this.buildPrefNames();
		this.buildShortNames();
		this.buildDefinitions();
		this.dsIEC61360.setPreferredNames(this.prefNames);
		this.dsIEC61360.setShortNames(this.shortNames);
		this.dsIEC61360.setDefinitions(this.definitions);
		this.dsIEC61360.setDataType(DataTypeIEC61360.STRING_TRANSLATABLE); // Hier kommt der DataType rein. Kein Valuetype auf Elementebene benutzen!
	}
	
	public DefaultConceptDescription get() {
		return this.conceptDescription;
	}
	
	public String getId() {
		return this.ID;
	}
}
