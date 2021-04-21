import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { ValidationServiceService } from './validation/validation.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private validationService: ValidationServiceService , private router: Router) { }

  ngOnInit(): void {
  }

  currentUser:User;
  email = '';
  password = '';

  validateUser() {
    this.validationService
      .validateUser(this.email, this.password)
      .subscribe((data) => {
        console.log(data);
       this.currentUser = data;
       console.log(this.currentUser);
       if(this.currentUser != null) {
         localStorage.setItem('isLoggedIn', 'true');
         localStorage.setItem('token', this.currentUser.email);
         localStorage.setItem('token2', this.currentUser.address);
      
         alert("Logged In Successfully");
         this.router.navigate(['/home']);
       }else{
         alert("Invalid username or password, please try again.")
       }
    });
  }
}
