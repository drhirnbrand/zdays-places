import { TestBed, async } from '@angular/core/testing';
import { PixelConfigurationForm } from './app.component';
describe('PixelConfigurationForm', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        PixelConfigurationForm
      ],
    }).compileComponents();
  }));
  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(PixelConfigurationForm);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
  it(`should have as title 'app'`, async(() => {
    const fixture = TestBed.createComponent(PixelConfigurationForm);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('app');
  }));
  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(PixelConfigurationForm);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to app!');
  }));
});
