package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.IdentifierType;
import io.adminshell.aas.v3.model.LangString;
import io.adminshell.aas.v3.model.impl.DefaultAdministrativeInformation;
import io.adminshell.aas.v3.model.impl.DefaultAsset;
import io.adminshell.aas.v3.model.impl.DefaultIdentifier;

public class JtAsset {

	private String                           id;
	private String                           idShort;
	private String                           descEn;
	private String                           descDe;
	private DefaultAsset                     asset          = new DefaultAsset();
	private List<LangString>                 descriptions   = new ArrayList<LangString>();
	private DefaultIdentifier                identifier     = new DefaultIdentifier();
	private DefaultAdministrativeInformation admInformation = new DefaultAdministrativeInformation();
	
	public JtAsset(String id, String idShort, String descEn, String descDe) {
		this.id = id;
		this.idShort = idShort;
		this.descEn = descEn;
		this.descDe = descDe;
		this.build();
	}
	
	private void build() {
		this.buildDescriptions();
		this.buildIdentifier();
		this.buildAdmInformation();
		asset.setIdShort(this.idShort);
		asset.setIdentification(this.identifier);
		asset.setDescriptions(this.descriptions);
		asset.setAdministration(this.admInformation);
	}
	
	private void buildIdentifier() {
		this.identifier.setIdType(IdentifierType.IRI);
		this.identifier.setIdentifier(this.id);
	}
	
	private void buildAdmInformation() {
		this.admInformation.setVersion("1.0");
	}
	
	private void buildDescriptions() {
		LangString descEN = new LangString();
		LangString descDE = new LangString();
		descEN.setValue(this.descEn);
		descEN.setLanguage("EN");
		descDE.setValue(this.descDe);
		descDE.setLanguage("DE");
		this.descriptions.add(descEN);
		this.descriptions.add(descDE);
	}
	
	public DefaultAsset get() {
		return asset;
	}
	
	public String getId() {
		return this.id;
	}
}
