package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.ConceptDescription;

public class JtIdentification extends JtSubmodel {

	private JtNameOfSupplier jtNameOfSupplier = new JtNameOfSupplier();
	private JtTypThumbnail jtTypThumbnail = new JtTypThumbnail();
	
	public JtIdentification(String id) {
		super(id);
		this.idShort = "Identification";
		this.globalReferenceIdentifier = "https://www.hsu-hh.de/aut/aas/identification";
		this.build();
	}
	
	public void buildElements() {
		this.elements.add(this.jtNameOfSupplier.get());
		this.elements.add(this.jtTypThumbnail.get());
	}
	
	public List<ConceptDescription> getConceptDescriptions() {
		List<ConceptDescription> conceptDescriptions = new ArrayList<ConceptDescription>();
		conceptDescriptions.add(this.jtNameOfSupplier.getConceptDescription());
		conceptDescriptions.add(this.jtTypThumbnail.getConceptDescription());
		return conceptDescriptions;
	}
	
	public void setNameOfSupplier(String nameOfSupplier) {
		this.jtNameOfSupplier.setValue(nameOfSupplier);
	}
	
	public void setTypThumbnail(String typThumbnail) {
		this.jtTypThumbnail.setValue(typThumbnail);
	}
}
