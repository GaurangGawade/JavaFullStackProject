import { Component, OnInit } from '@angular/core';
import { User } from '../user.model';
import { UserService } from '../Services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrl: './user-update.component.css'
})
export class UserUpdateComponent implements OnInit {
  id!: number;
  user: User = new User();
  constructor(private userService: UserService,
  private route: ActivatedRoute, private router: Router) { }
  private getStudentById() {
  this.id = this.route.snapshot.params['id'];
  this.userService.getStudentById(this.id).subscribe({
  next: (data) => {
  this.user = data;
  },
  error: (e) => {
  console.log(e);
  }
  });
  }
  ngOnInit(): void {
  this.getStudentById();
  }
  updateUser() {
  this.userService.updateStudent(this.id, this.user).subscribe({
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
  this.updateUser();
  }
 }