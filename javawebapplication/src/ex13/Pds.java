package ex13;

public class Pds {
	private int id;
	private String fileName;
	private long fileSize;
	private String description;
	
	
	public Pds() {
		super();
	}
	
	public Pds(int id, String fileName, long fileSize, String description) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Pds [id=" + id + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", description=" + description + "]";
	}	
}

