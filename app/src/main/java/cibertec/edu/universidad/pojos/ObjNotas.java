
package cibertec.edu.universidad.pojos;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjNotas implements Serializable, Parcelable
{

    @SerializedName("AMoviles")
    @Expose
    private Integer aMoviles;
    @SerializedName("Finanzas")
    @Expose
    private Integer finanzas;
    @SerializedName("Redes")
    @Expose
    private Integer redes;
    @SerializedName("DisenioWeb")
    @Expose
    private Integer disenioWeb;
    @SerializedName("CodigoAlumno")
    @Expose
    private String codigoAlumno;
    @SerializedName("Eliminado")
    @Expose
    private Boolean eliminado;
    @SerializedName("CodigoError")
    @Expose
    private Integer codigoError;
    @SerializedName("DescripcionError")
    @Expose
    private String descripcionError;
    @SerializedName("MensajeError")
    @Expose
    private Object mensajeError;
    public final static Creator<ObjNotas> CREATOR = new Creator<ObjNotas>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ObjNotas createFromParcel(Parcel in) {
            return new ObjNotas(in);
        }

        public ObjNotas[] newArray(int size) {
            return (new ObjNotas[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5136720546735539622L;

    protected ObjNotas(Parcel in) {
        this.aMoviles = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.finanzas = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.redes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.disenioWeb = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.codigoAlumno = ((String) in.readValue((String.class.getClassLoader())));
        this.eliminado = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.codigoError = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.descripcionError = ((String) in.readValue((String.class.getClassLoader())));
        this.mensajeError = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public ObjNotas() {
    }

    public Integer getAMoviles() {
        return aMoviles;
    }

    public void setAMoviles(Integer aMoviles) {
        this.aMoviles = aMoviles;
    }

    public Integer getFinanzas() {
        return finanzas;
    }

    public void setFinanzas(Integer finanzas) {
        this.finanzas = finanzas;
    }

    public Integer getRedes() {
        return redes;
    }

    public void setRedes(Integer redes) {
        this.redes = redes;
    }

    public Integer getDisenioWeb() {
        return disenioWeb;
    }

    public void setDisenioWeb(Integer disenioWeb) {
        this.disenioWeb = disenioWeb;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Integer getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public Object getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(Object mensajeError) {
        this.mensajeError = mensajeError;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(aMoviles);
        dest.writeValue(finanzas);
        dest.writeValue(redes);
        dest.writeValue(disenioWeb);
        dest.writeValue(codigoAlumno);
        dest.writeValue(eliminado);
        dest.writeValue(codigoError);
        dest.writeValue(descripcionError);
        dest.writeValue(mensajeError);
    }

    public int describeContents() {
        return  0;
    }

}
