import { Component, OnInit } from '@angular/core';
import { ShipService } from 'src/app/services/ship.service';

@Component({
  selector: 'app-ships-list',
  templateUrl: './ships-list.component.html',
  styleUrls: ['./ships-list.component.css']
})
export class ShipsListComponent implements OnInit {

 ships: any;
  currentShip = null;
  currentIndex = -1;
  name = '';

  constructor(private shipService: ShipService) { }

  ngOnInit() {
    this.retrieveShips();
  }

  retrieveShips() {
    this.shipService.getAll()
      .subscribe(
        data => {
          this.ships = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList() {
    this.retrieveShips();
    this.currentShip = null;
    this.currentIndex = -1;
  }

  setActiveShip(ship, index) {
    this.currentShip = ship;
    this.currentIndex = index;
  }

  removeAllShips() {
    this.shipService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.retrieveShips();
        },
        error => {
          console.log(error);
        });
  }

  searchName() {
    this.shipService.findByShipContaining(this.name)
      .subscribe(
        data => {
          this.ships = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
