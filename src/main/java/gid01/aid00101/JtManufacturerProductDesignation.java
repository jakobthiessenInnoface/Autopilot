package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.Key;
import io.adminshell.aas.v3.model.KeyElements;
import io.adminshell.aas.v3.model.KeyType;
import io.adminshell.aas.v3.model.impl.DefaultConceptDescription;
import io.adminshell.aas.v3.model.impl.DefaultProperty;
import io.adminshell.aas.v3.model.impl.DefaultReference;

public class JtManufacturerProductDesignation {

	private DefaultProperty                     manufacturerProductDesignation = new DefaultProperty();
	private MyKey                               keyToConceptDescription        = new MyKey();
	private DefaultReference                    semanticId                     = new DefaultReference();
	private CDforManufacturerProductDesignation cd                             = new CDforManufacturerProductDesignation();
	
	public JtManufacturerProductDesignation() {
		this.build();
	}
	
	private void build() {
		this.buildSemanticId();
		this.manufacturerProductDesignation.setIdShort("ManufacturerProductDesignation");
		this.manufacturerProductDesignation.setSemanticId(this.semanticId);
		this.manufacturerProductDesignation.setCategory("PARAMETER");
	}
	
	private void buildSemanticId() {
		this.buildKeyToConceptDescription();
		List<Key> keys = new ArrayList<Key>();
		keys.add(this.keyToConceptDescription);
		this.semanticId.setKeys(keys);
	}
	
	private void buildKeyToConceptDescription() {
		this.keyToConceptDescription.setType(KeyElements.CONCEPT_DESCRIPTION);
		this.keyToConceptDescription.setIdType(KeyType.IRDI);
		this.keyToConceptDescription.setValue(this.cd.getId());
		this.keyToConceptDescription.setLocal(Boolean.TRUE);
	}
	
	public DefaultProperty get() {
		return this.manufacturerProductDesignation;
	}
	
	public DefaultConceptDescription getConceptDescription() {
		return this.cd.get();
	}
	public void setValue(String value) {
		this.manufacturerProductDesignation.setValue(value);
	}
}
