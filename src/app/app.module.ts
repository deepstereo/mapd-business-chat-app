import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';

import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { environment } from './../environments/environment';
import { AppNavbarComponent } from './app-navbar/app-navbar.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppFooterComponent } from './app-footer/app-footer.component';
import { RegistrationComponent } from './registration/registration.component';
import { ContentComponent } from './content/content.component';

import { AuthService } from './services/auth.service';
import { ChatComponent } from './chat/chat.component';

import { RouterModule } from '@angular/router';
import { appRoutes } from '../routes';


@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    AppFooterComponent,
    RegistrationComponent,
    ContentComponent,
    ChatComponent
  ],
  imports: [
    BrowserModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireDatabaseModule,
    AngularFireAuthModule,
    NgbModule.forRoot(),
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }