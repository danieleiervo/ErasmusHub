import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/app/services/log.service';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private log: LogService) { }

  ngOnInit(): void {
  }

}
