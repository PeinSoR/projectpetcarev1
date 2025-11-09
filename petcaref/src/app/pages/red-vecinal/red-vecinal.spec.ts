import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RedVecinal } from './red-vecinal';

describe('RedVecinal', () => {
  let component: RedVecinal;
  let fixture: ComponentFixture<RedVecinal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RedVecinal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RedVecinal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
