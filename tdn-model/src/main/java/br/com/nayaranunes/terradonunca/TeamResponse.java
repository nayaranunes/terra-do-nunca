package br.com.nayaranunes.terradonunca;


public class TeamResponse {
    private String coach;
    private String cnpj;
    private String name;

    public TeamResponse() {
        super();
    }

    public TeamResponse(String coach, String cnpj,
                       String name) {
        this.coach = coach;
        this.cnpj = cnpj;
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}