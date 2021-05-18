import { Component, OnInit } from '@angular/core';
import { ShipService } from 'src/app/services/ship.service';

@Component({
  selector: 'app-add-ship',
  templateUrl: './add-ship.component.html',
  styleUrls: ['./add-ship.component.css']
})
export class AddShipComponent implements OnInit {

  ship = {
    name: '',
    captain: ''
  };
  submitted = false;

  constructor(private shipService: ShipService) { }

  ngOnInit() {
  }

  saveShip() {
    const data = {
      name: this.ship.name,
      captain: this.ship.captain
    };

    this.shipService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newShip() {
    this.submitted = false;
    this.ship = {
      name: '',
      captain: ''
    };
  }
}