import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Finanzas } from './finanzas';

describe('Finanzas', () => {
  let component: Finanzas;
  let fixture: ComponentFixture<Finanzas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Finanzas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Finanzas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
