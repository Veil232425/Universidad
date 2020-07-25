
package cibertec.edu.universidad.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotasResponse implements Serializable, Parcelable
{

    @SerializedName("ObjNotas")
    @Expose
    private ObjNotas objNotas;
    @SerializedName("ObjListaNotas")
    @Expose
    private List<ObjListaNota> objListaNotas = new ArrayList<ObjListaNota>();
    public final static Creator<NotasResponse> CREATOR = new Creator<NotasResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NotasResponse createFromParcel(Parcel in) {
            return new NotasResponse(in);
        }

        public NotasResponse[] newArray(int size) {
            return (new NotasResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4382225164841523169L;

    protected NotasResponse(Parcel in) {
        this.objNotas = ((ObjNotas) in.readValue((ObjNotas.class.getClassLoader())));
        in.readList(this.objListaNotas, (cibertec.edu.universidad.pojos.ObjListaNota.class.getClassLoader()));
    }

    public NotasResponse() {
    }

    public ObjNotas getObjNotas() {
        return objNotas;
    }

    public void setObjNotas(ObjNotas objNotas) {
        this.objNotas = objNotas;
    }

    public List<ObjListaNota> getObjListaNotas() {
        return objListaNotas;
    }

    public void setObjListaNotas(List<ObjListaNota> objListaNotas) {
        this.objListaNotas = objListaNotas;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(objNotas);
        dest.writeList(objListaNotas);
    }

    public int describeContents() {
        return  0;
    }

}
