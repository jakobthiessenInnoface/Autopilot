package gid01.aid00101;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.adminshell.aas.v3.model.AdministrativeInformation;
import io.adminshell.aas.v3.model.AssetAdministrationShell;
import io.adminshell.aas.v3.model.AssetInformation;
import io.adminshell.aas.v3.model.EmbeddedDataSpecification;
import io.adminshell.aas.v3.model.Extension;
import io.adminshell.aas.v3.model.Identifier;
import io.adminshell.aas.v3.model.LangString;
import io.adminshell.aas.v3.model.Reference;
import io.adminshell.aas.v3.model.Security;
import io.adminshell.aas.v3.model.View;
import io.adminshell.aas.v3.model.annotations.IRI;
import io.adminshell.aas.v3.model.builder.AssetAdministrationShellBuilder;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShell;

/**
 * Default implementation of package io.adminshell.aas.v3.model.AssetAdministrationShell
 * 
 * Describes the Administration Shell for Assets, Products, Components, e.g. Machines
 */

@IRI("aas:AssetAdministrationShell")
public class MyAssetAdministrationShell implements AssetAdministrationShell {

    @IRI("https://admin-shell.io/aas/3/0/RC01/AssetAdministrationShell/assetInformation")
    protected AssetInformation assetInformation;

    @IRI("https://admin-shell.io/aas/3/0/RC01/AssetAdministrationShell/derivedFrom")
    protected Reference derivedFrom;

    @IRI("https://admin-shell.io/aas/3/0/RC01/AssetAdministrationShell/security")
    protected Security security;

    @IRI("https://admin-shell.io/aas/3/0/RC01/AssetAdministrationShell/submodel")
    protected List<Reference> submodels = new ArrayList<>();

    @IRI("https://admin-shell.io/aas/3/0/RC01/AssetAdministrationShell/view")
    protected List<View> views = new ArrayList<>();

    @IRI("https://admin-shell.io/aas/3/0/RC01/HasDataSpecification/embeddedDataSpecification")
    protected List<EmbeddedDataSpecification> embeddedDataSpecifications = new ArrayList<>();

    @IRI("https://admin-shell.io/aas/3/0/RC01/HasExtensions/extension")
    protected List<Extension> extensions = new ArrayList<>();

    @IRI("https://admin-shell.io/aas/3/0/RC01/Identifiable/administration")
    protected AdministrativeInformation administration;

    @IRI("https://admin-shell.io/aas/3/0/RC01/Identifiable/identification")
    protected Identifier identification;

    @IRI("https://admin-shell.io/aas/3/0/RC01/Referable/category")
    protected String category;

    @IRI("https://admin-shell.io/aas/3/0/RC01/Referable/description")
    protected List<LangString> descriptions = new ArrayList<>();

    @IRI("https://admin-shell.io/aas/3/0/RC01/Referable/displayName")
    protected List<LangString> displayNames = new ArrayList<>();

    @IRI("https://admin-shell.io/aas/3/0/RC01/Referable/idShort")
    protected String idShort;

    protected Reference asset;
    
    public MyAssetAdministrationShell() {}

    @Override
    public int hashCode() {
        return Objects.hash(this.assetInformation,
            this.derivedFrom,
            this.security,
            this.submodels,
            this.views,
            this.embeddedDataSpecifications,
            this.administration,
            this.identification,
            this.category,
            this.descriptions,
            this.displayNames,
            this.idShort,
            this.extensions);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            MyAssetAdministrationShell other = (MyAssetAdministrationShell) obj;
            return Objects.equals(this.assetInformation, other.assetInformation) &&
                Objects.equals(this.derivedFrom, other.derivedFrom) &&
                Objects.equals(this.security, other.security) &&
                Objects.equals(this.submodels, other.submodels) &&
                Objects.equals(this.views, other.views) &&
                Objects.equals(this.embeddedDataSpecifications, other.embeddedDataSpecifications) &&
                Objects.equals(this.administration, other.administration) &&
                Objects.equals(this.identification, other.identification) &&
                Objects.equals(this.category, other.category) &&
                Objects.equals(this.descriptions, other.descriptions) &&
                Objects.equals(this.displayNames, other.displayNames) &&
                Objects.equals(this.idShort, other.idShort) &&
                Objects.equals(this.extensions, other.extensions);
        }
    }

    @Override
    public AssetInformation getAssetInformation() {
        return assetInformation;
    }

    @Override
    public void setAssetInformation(AssetInformation assetInformation) {
        this.assetInformation = assetInformation;
    }

    @Override
    public Reference getDerivedFrom() {
        return derivedFrom;
    }

    @Override
    public void setDerivedFrom(Reference derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    @Override
    public Security getSecurity() {
        return security;
    }

    @Override
    public void setSecurity(Security security) {
        this.security = security;
    }

    @Override
    public List<Reference> getSubmodels() {
        return submodels;
    }

    @Override
    public void setSubmodels(List<Reference> submodels) {
        this.submodels = submodels;
    }

    @Override
    public List<View> getViews() {
        return views;
    }

    @Override
    public void setViews(List<View> views) {
        this.views = views;
    }

    @Override
    public List<EmbeddedDataSpecification> getEmbeddedDataSpecifications() {
        return embeddedDataSpecifications;
    }

    @Override
    public void setEmbeddedDataSpecifications(List<EmbeddedDataSpecification> embeddedDataSpecifications) {
        this.embeddedDataSpecifications = embeddedDataSpecifications;
    }

    @Override
    public AdministrativeInformation getAdministration() {
        return administration;
    }

    @Override
    public void setAdministration(AdministrativeInformation administration) {
        this.administration = administration;
    }

    @Override
    public Identifier getIdentification() {
        return identification;
    }

    @Override
    public void setIdentification(Identifier identification) {
        this.identification = identification;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public List<LangString> getDescriptions() {
        return descriptions;
    }

    @Override
    public void setDescriptions(List<LangString> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public List<LangString> getDisplayNames() {
        return displayNames;
    }

    @Override
    public void setDisplayNames(List<LangString> displayNames) {
        this.displayNames = displayNames;
    }

    @Override
    public String getIdShort() {
        return idShort;
    }

    @Override
    public void setIdShort(String idShort) {
        this.idShort = idShort;
    }

    /**
     * This builder class can be used to construct a DefaultAssetAdministrationShell bean.
     */
    public static class Builder extends AssetAdministrationShellBuilder<DefaultAssetAdministrationShell, Builder> {

        @Override
        protected Builder getSelf() {
            return this;
        }

        @Override
        protected DefaultAssetAdministrationShell newBuildingInstance() {
            return new DefaultAssetAdministrationShell();
        }
    }
    
    public void setAsset(Reference asset) {
        this.asset = asset;
    }
    public Reference getAsset() {
        return this.asset;
    }

	@Override
	public List<Extension> getExtensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExtensions(List<Extension> extensions) {
		// TODO Auto-generated method stub
		
	}
}