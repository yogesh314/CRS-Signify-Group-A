import { User } from "./user";

export class Student extends User {
    public studentid:string;
    public age:number;
    public fname:string;
    public bloodgroup:string;
    public phnum:string;
    public branch:string;


    constructor(name:string,userId:string,address:string,password:string,doj:string,studentid:string,age:number,fname:string,bloodgroup:string,phnum:string,branch:string){
        super(name, userId, address, password, doj);
        this.studentid=studentid;
        this.age=age;
        this.fname=fname;   
        this.bloodgroup=bloodgroup;
        this.phnum=phnum;
        this.branch=branch;



    }
}
    
