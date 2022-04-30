package de.nicoismaili.qontract.data.contract.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.nicoismaili.qontract.data.contract.ContractConverters;

/**
 * Contract entity containing Room information to
 * create contract rows in the database.
 *
 * @author Nico Ismaili
 */
@Entity(tableName = "contracts")
@TypeConverters({ContractConverters.class})
public class Contract implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contract_id")
    private int id;
    @ColumnInfo(name = "signed")
    @NonNull
    private boolean isSigned;
    @ColumnInfo(name = "read")
    private boolean isRead;
    @NonNull
    private Date date;
    @NonNull
    private String location;
    @ColumnInfo(name = "model_first_name")
    @NonNull
    private String modelFirstname;
    @ColumnInfo(name = "model_last_name")
    @NonNull
    private String modelLastname;
    private String modelAddress;
    private String modelPhone;
    private String modelEmail;
    @ColumnInfo(name = "images_json")
    // Contains paths to the images belonging to a contract
    private List<String> images;
    // Contains the entire contract as an html string
    private String contractHTML;
    // Contains the signature of the model as an SVG
    private String modelSignatureSVG;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    public void setLocation(@NonNull String location) {
        this.location = location;
    }

    @NonNull
    public String getModelFirstname() {
        return modelFirstname;
    }

    public void setModelFirstname(@NonNull String modelFirstname) {
        this.modelFirstname = modelFirstname;
    }

    @NonNull
    public String getModelLastname() {
        return modelLastname;
    }

    public void setModelLastname(@NonNull String modelLastname) {
        this.modelLastname = modelLastname;
    }

    @NonNull
    public String getModelAddress() {
        return modelAddress;
    }

    public void setModelAddress(@NonNull String modelAddress) {
        this.modelAddress = modelAddress;
    }

    @NonNull
    public String getModelPhone() {
        return modelPhone;
    }

    public void setModelPhone(@NonNull String modelPhone) {
        this.modelPhone = modelPhone;
    }

    @NonNull
    public String getModelEmail() {
        return modelEmail;
    }

    public void setModelEmail(@NonNull String modelEmail) {
        this.modelEmail = modelEmail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getContractHTML() {
        return contractHTML;
    }

    public void setContractHTML(String contractHTML) {
        this.contractHTML = contractHTML;
    }

    public String getModelSignatureSVG() {
        return modelSignatureSVG;
    }

    public void setModelSignatureSVG(String modelSignatureSVG) {
        this.modelSignatureSVG = modelSignatureSVG;
    }
}
