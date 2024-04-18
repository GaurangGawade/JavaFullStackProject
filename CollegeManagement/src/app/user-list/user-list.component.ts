import { Component } from '@angular/core';
import { UserService } from '../Services/user.service';
import { User } from '../user.model';
import { Router } from '@angular/router';
import * as XLSX from 'xlsx';



@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})




export class UserListComponent {
  users: User[] | undefined;
  searchtext:any;
  ableData: any[] = [];
  constructor(private userService: UserService, private router: Router) {
  }


  
  ngOnInit(): void {
  this.getStudents();
  }
  private getStudents() {
  this.userService.getStudentList().subscribe(data => {
  this.users = data;
  });
  }
  updateStudent(id: number) {
  this.router.navigate(['update-user', id]);
  }
  deleteStudent(id: number) {
  this.userService.deleteStudent(id).subscribe(data => {
  console.log(data);
  this.getStudents();
  });
  }

  fileName = 'StudentData.xlsx';
  exportexcel() {
    /*passing table id*/
    let data = document.getElementById('students_table');
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(data);

    /*Generate workbook and add the worksheet*/
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /save to file/
    XLSX.writeFile(wb, this.fileName);
  }

  
 }
 

