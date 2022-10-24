package pillihuaman.com.basebd.imagenProducer.domain;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;

public class ImagenFile implements Serializable {

	private static final long serialVersionUID = -4814933202447166308L;

	private ObjectId _id ;
	private String filename ;
	private List<File> file;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}


	

}