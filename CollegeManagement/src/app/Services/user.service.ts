import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl="http://localhost:9196/user";

  constructor(private httpClient:HttpClient) { }

  getStudentList():Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }
  createStudent(user:User):Observable<Object>
  {
    return this.httpClient.post(`${this.baseUrl}`,user);
  }
  getStudentById(id:number):Observable<User>{
    return this.httpClient.get<User>(`${this.baseUrl}${id}`);
  }
  updateStudent(id:number,user:User):Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,user);
  }
  deleteStudent(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
