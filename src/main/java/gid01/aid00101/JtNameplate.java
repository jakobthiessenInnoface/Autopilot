package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.ConceptDescription;

public class JtNameplate extends JtSubmodel {

	private JtManufacturerName jtManufacturerName = new JtManufacturerName();
	private JtManufacturerProductDesignation jtManufacturerProductDesignation = new JtManufacturerProductDesignation();
	
	public JtNameplate(String id) {
		super(id);
		this.globalReferenceIdentifier = "https://www.hsu-hh.de/aut/aas/nameplate";
		this.idShort = "Nameplate";
		this.build();
	}
	
	public void buildElements() {
		this.elements.add(this.jtManufacturerName.get());
		this.elements.add(this.jtManufacturerProductDesignation.get());
	}
	
	public List<ConceptDescription> getConceptDescriptions() {
		List<ConceptDescription> conceptDescriptions = new ArrayList<ConceptDescription>();
		conceptDescriptions.add(this.jtManufacturerName.getConceptDescription());
		conceptDescriptions.add(this.jtManufacturerProductDesignation.getConceptDescription());
		return conceptDescriptions;
	}
	
	public void setManufacturerName(String manufacturerName) {
		this.jtManufacturerName.setValue(manufacturerName);
	}
	
	public void setManufacturerProductDesignation(String manufacturerProductDesignation) {
		this.jtManufacturerProductDesignation.setValue(manufacturerProductDesignation);
	}
}
