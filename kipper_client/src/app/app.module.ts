import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddShipComponent } from './components/add-ship/add-ship.component';
import { ShipDetailsComponent } from './components/ship-details/ship-details.component';
import { ShipsListComponent } from './components/ships-list/ships-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddShipComponent,
    ShipDetailsComponent,
    ShipsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
