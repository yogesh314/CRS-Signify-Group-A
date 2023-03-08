export class User {

    public name:string;
    public userId:string;
    public address:string;
    public password:string;
    public doj:string;
    
    constructor(name:string,userId:string,address:string,password:string,doj:string){
        this.name=name;
        this.userId=userId;
        this.address=address;
        this.password=password;
        this.doj=doj;
    }
}
