package yak.shop.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement 
public class Herd {

	
	private List<YakEntity> labyak;

	@XmlElement 
	public List<YakEntity> getLabyak() {
		return labyak;
	}

	public void setLabyak(List<YakEntity> labyak) {
		this.labyak = labyak;
	}

	
}
