import { Component, OnInit } from '@angular/core';
import { User } from '../user.model';
import { UserService } from '../Services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrl: './user-create.component.css'
})
export class UserCreateComponent implements OnInit {
  user: User = new User();
  img = "../../assets/img1.jpeg"
  constructor(private userService: UserService, private router: Router) { }
  ngOnInit(): void {
  }
  saveStudent() {
  this.userService.createStudent(this.user).subscribe({
  next: (data) => {
  console.log(data);
  this.redirectToStudentList();
  },
  error: (e) => {
  console.log(e);
  }
  });
  }
  redirectToStudentList() {
  this.router.navigate(['/users']);
  }

  onSubmit() {
  console.log(this.user);
  this.saveStudent();
  }
 }