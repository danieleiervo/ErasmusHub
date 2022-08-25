import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/app/services/log.service';
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/models/Post';

@Component({
  selector: 'mobile-home-nouser',
  templateUrl: './mobile-home-nouser.component.html',
  styleUrls: ['./mobile-home-nouser.component.css']
})
export class MobileHomeNoUserComponent implements OnInit {

  lastPost: Post[];

  constructor(private postService: PostService, private log: LogService) { }

  ngOnInit(): void {
    this.activeNavbar();
    this.getLastPost();
  }


  activeNavbar() {
    let icon = document.getElementsByClassName('bxs-home') as HTMLCollectionOf<HTMLElement>;

    if (icon.length != 0) {
      icon[0].style.color = "#005bbc";
      icon[0].style.textShadow = "-1px 4px 6px rgba(0, 0, 0, 0.25)";
    }
  }

  getLastPost() {
    this.postService.findAll().subscribe(
      (resp)=>{
        this.lastPost = resp as Post[];
      },
      (error)=>{
        this.log.Error(MobileHomeNoUserComponent.name, "Errore", [error]);
      }
    )

  }

}

