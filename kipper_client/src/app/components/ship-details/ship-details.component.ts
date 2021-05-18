import { Component, OnInit } from '@angular/core';
import { ShipService } from 'src/app/services/ship.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ship-details',
  templateUrl: './ship-details.component.html',
  styleUrls: ['./ship-details.component.css']
})
export class ShipDetailsComponent implements OnInit {

currentShip = null;
  message = '';

  constructor(
    private shipService: ShipService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.message = '';
    this.getShip(this.route.snapshot.paramMap.get('id'));
  }

  getShip(id) {
    this.shipService.get(id)
      .subscribe(
        data => {
          this.currentShip = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updateShip() {
    this.shipService.update(this.currentShip.id, this.currentShip)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The ship was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteShip() {
    this.shipService.delete(this.currentShip.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/ships']);
        },
        error => {
          console.log(error);
        });
  }
}
