package br.com.unip.helpdesk.message;

public class Response {
	
	private Integer codigo;
	private Object data;
	
	public Response(){
		
	}
	
	public Response(Integer  codigo, Object data){
		this.codigo = codigo;
		this.data = data;
	}
 
	
 
	public Object getData() {
		return data;
	}
 
	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
