import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/ships';

@Injectable({
  providedIn: 'root'
})
export class ShipService {

constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(baseUrl);
  }

  get(id) {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data) {
    return this.http.post(baseUrl, data);
  }

  update(id, data) {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl);
  }

  findByShipNamePart(name) {
    return this.http.get(`${baseUrl}/ship/?name=${name}`);
  }

  findByCaptain(captain) {
    return this.http.get(`${baseUrl}/ship/captain/part?name=${captain}`);
  }
}
