import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZPlacesCardComponent } from './z-places-card.component';

describe('ZPlacesCardComponent', () => {
  let component: ZPlacesCardComponent;
  let fixture: ComponentFixture<ZPlacesCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZPlacesCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZPlacesCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
