import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomepageComponent } from './components/homepage/homepage.component';

import { LogService } from './services/log.service';
import { MobileHeaderComponent } from './components/mobile-header/mobile-header.component';
import { MobileNavbarComponent } from './components/mobile-navbar/mobile-navbar.component';
import { MobileHomeNoUserComponent } from './components/mobile-home-nouser/mobile-home-nouser.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    MobileHomeNoUserComponent,
    MobileHeaderComponent,
    MobileNavbarComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [LogService],
  bootstrap: [AppComponent]
})

export class AppModule { }
