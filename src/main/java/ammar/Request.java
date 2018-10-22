package ammar;

import javax.persistence.*;


@Entity
@Table(name = "requests")
public class Request {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private int request_id;

    @Column(name = "requests")
    private int request;

    @Id
    @Column(name = "id")
    private int id;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Request() {  }
    public Request(int request_id, int request, int id) {
        this.setRequest_id(request_id);
        this.setRequest(request);
        this.setId(id);
    }

    public int getRequest_id() {
        return request_id;
    }
    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }
    public int getRequest() {
        return request;
    }
    public void setRequest(int request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request_id=" + request_id +
                ", Requests= " + request + '\''+
                '}';
    }



}
