package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;

import io.adminshell.aas.v3.model.Asset;
import io.adminshell.aas.v3.model.AssetAdministrationShell;
import io.adminshell.aas.v3.model.ConceptDescription;
import io.adminshell.aas.v3.model.Submodel;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShellEnvironment;

public class JtEnv {

	private JtNameplate jtNameplate;
	private JtIdentification jtIdentification;
	private JtAsset jtAsset;
	private JtAAS jtAas;
	private JtAAS jtAas2;
	private DefaultAssetAdministrationShellEnvironment env       = new DefaultAssetAdministrationShellEnvironment();
	private List<AssetAdministrationShell>             aasList   = new ArrayList<AssetAdministrationShell>();
	private List<Asset>                                assets    = new ArrayList<Asset>();
	private List<Submodel>                             submodels = new ArrayList<Submodel>();
	
	public JtEnv(JtAsset jtAsset, JtAAS jtAas, JtAAS jtAas2, JtNameplate jtNameplate, JtIdentification jtIdentification) {
		this.jtAsset     = jtAsset;
		this.jtAas       = jtAas;
		this.jtAas2      = jtAas2;
		this.jtNameplate = jtNameplate;
		this.jtIdentification = jtIdentification;
		this.build();
	}
	
	private void build() {
		this.aasList.add(this.jtAas.get());
		//this.aasList.add(this.jtAas2.get());
		this.assets.add(this.jtAsset.get());
		this.submodels.add(this.jtNameplate.get());
		this.submodels.add(this.jtIdentification.get());
		this.env.setAssetAdministrationShells(this.aasList);
		this.env.setAssets(this.assets);
		this.env.setSubmodels(this.submodels);
		
		List<ConceptDescription> conceptDescriptions = new ArrayList<ConceptDescription>();
		conceptDescriptions.add(jtNameplate.getConceptDescriptions().get(0));
		conceptDescriptions.add(jtNameplate.getConceptDescriptions().get(1));
		conceptDescriptions.add(jtIdentification.getConceptDescriptions().get(0));
		conceptDescriptions.add(jtIdentification.getConceptDescriptions().get(1));
		env.setConceptDescriptions(conceptDescriptions);
	}
	
	public DefaultAssetAdministrationShellEnvironment get() {
		return env;
	}
	
}
