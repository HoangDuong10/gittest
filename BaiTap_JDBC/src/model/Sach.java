package model;

public class Sach {
	private String id;
	private String tenSach;
	private float giaban;
	private int namXuatBan;
	
	
	public Sach() {
		super();
	}


	public Sach(String id, String tenSach, float giaban, int namXuatBan) {
		super();
		this.id = id;
		this.tenSach = tenSach;
		this.giaban = giaban;
		this.namXuatBan = namXuatBan;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTenSach() {
		return tenSach;
	}


	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}


	public float getGiaban() {
		return giaban;
	}


	public void setGiaban(float giaban) {
		this.giaban = giaban;
	}


	public int getNamXuatBan() {
		return namXuatBan;
	}


	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}


	@Override
	public String toString() {
		return "Sach [id=" + id + ", tenSach=" + tenSach + ", giaban=" + giaban + ", namXuatBan=" + namXuatBan + "]";
	}


	
	
}
