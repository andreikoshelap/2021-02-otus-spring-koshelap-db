import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShipsListComponent } from './components/ships-list/ships-list.component';
import { ShipDetailsComponent } from './components/ship-details/ship-details.component';
import { AddShipComponent } from './components/add-ship/add-ship.component';


const routes: Routes = [
  { path: '', redirectTo: 'ships', pathMatch: 'full' },
  { path: 'ships', component: ShipsListComponent },
  { path: 'ships/:id', component: ShipDetailsComponent },
  { path: 'add', component: AddShipComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
