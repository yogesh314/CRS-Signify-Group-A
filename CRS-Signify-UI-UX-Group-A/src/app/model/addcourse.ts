export class Addcourse {

    public studentid:string;
    public coursecode:string;
    public type:number;

    constructor(studentid:string,coursecode:string,type:number ){
        this.studentid = studentid;
        this.coursecode = coursecode;
        this.type = type;
    }
}
